import com.datastax.oss.driver.api.core.data.UdtValue;
import com.datastax.oss.driver.api.core.type.UserDefinedType;
import com.datastax.oss.driver.api.core.type.codec.MappingCodec;
import com.datastax.oss.driver.api.core.type.codec.TypeCodec;
import com.datastax.oss.driver.api.core.type.reflect.GenericType;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import models.Office;

public class OfficeCodec extends MappingCodec<UdtValue, Office> {


    public OfficeCodec(@NonNull TypeCodec<UdtValue> innerCodec) {
        super(innerCodec, GenericType.of(Office.class));
    }


    @NonNull
    @Override
    public UserDefinedType getCqlType() {
        return (UserDefinedType) super.getCqlType();
    }


    @Nullable
    @Override
    protected Office innerToOuter(@Nullable UdtValue office) {
        return office == null ? null : new Office(
                office.getString("uniqueID"),
                office.getString("address"),
                office.getInt("rating")
        );
    }

    @Nullable
    @Override
    protected UdtValue outerToInner(@Nullable Office office) {
        return office == null ? null : getCqlType().newValue()
                .setString("uniqueID", office.getUniqueID())
                .setString("address", office.getAddress())
                .setInt("rating", office.getRating());

    }
}