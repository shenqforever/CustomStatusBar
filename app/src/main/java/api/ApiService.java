package api;



import entity.Book;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by sq719 on 2018/3/5.
 *
 */

public interface ApiService {
    //@GET(APP_SERVICES)
    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name, @Query("tag") String tag,
                                    @Query("start") int start, @Query("count") int count);

}
