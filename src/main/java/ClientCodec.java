import com.datastax.oss.driver.api.core.data.UdtValue;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import com.datastax.oss.driver.api.core.type.codec.MappingCodec;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.reflect.GenericType;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import models.Client;

public class ClientCodec extends MappingCodec<UdtValue, Client> {


    public ClientCodec(@NonNull TypeCodec<UdtValue> innerCodec) {
        super(innerCodec, GenericType.of(Client.class));
    }


    @NonNull
    @Override
    public UserDefinedType getCqlType() {
        return (UserDefinedType) super.getCqlType();
    }


    @Nullable
    @Override
    protected Client innerToOuter(@Nullable UdtValue client) {
        return client == null ? null : new Client(
                client.getString("name"),
                client.getString("surname"),
                client.getString("pesel"),
                client.getString("phoneNumber")
        );
    }

    @Nullable
    @Override
    protected UdtValue outerToInner(@Nullable Client client) {
        return client == null ? null : getCqlType().newValue()
                .setString("name", client.getName())
                .setString("surname", client.getSurname())
                .setString("pesel", client.getPesel())
                .setString("phoneNumber", client.getPhoneNumer());
    }
}