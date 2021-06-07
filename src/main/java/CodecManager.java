import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.data.UdtValue;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.codec.registry.CodecRegistry;
import com.datastax.oss.driver.api.core.type.codec.registry.MutableCodecRegistry;

public class CodecManager extends SimpleManager {

    public CodecManager(CqlSession session) {
        super(session);
    }


    public void registerClientCodec() {
        CodecRegistry codecRegistry = session.getContext().getCodecRegistry();
        UserDefinedType clientUdt =
                session
                        .getMetadata()
                        .getKeyspace("offer")
                        .flatMap(ks -> ks.getUserDefinedType("client"))
                        .orElseThrow(IllegalStateException::new);
        TypeCodec<UdtValue> typeCodec = codecRegistry.codecFor(clientUdt);
        ClientCodec clientCodec = new ClientCodec(typeCodec);
        ((MutableCodecRegistry) codecRegistry).register(clientCodec);
    }
    public void registerOfficeCodec() {
        CodecRegistry codecRegistry = session.getContext().getCodecRegistry();
        UserDefinedType officeUdt =
                session
                        .getMetadata()
                        .getKeyspace("offer")
                        .flatMap(ks -> ks.getUserDefinedType("office"))
                        .orElseThrow(IllegalStateException::new);
        TypeCodec<UdtValue> typeCodec = codecRegistry.codecFor(officeUdt);
        OfficeCodec officeCodec = new OfficeCodec(typeCodec);
        ((MutableCodecRegistry) codecRegistry).register(officeCodec);
    }
}