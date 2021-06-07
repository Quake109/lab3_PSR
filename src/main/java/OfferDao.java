import com.datastax.oss.driver.api.core.PagingIterable;
import com.datastax.oss.driver.api.mapper.annotations.*;
import models.Offer;

import java.util.Optional;


@Dao
public interface OfferDao {

    @Insert
    Offer save(Offer offer);

    @Select
    Optional<Offer> getById(int id);

    @Select
    Offer getByIdOffer(int id);

    @Select
    Offer getByRating(int rating);

    @Update
    void updateByRating(Offer offer, int id, int rating);

    @Delete
    void delete(Offer offer);

    @Select
    PagingIterable<Offer> getAll();

}