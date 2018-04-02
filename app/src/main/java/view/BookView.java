package view;

import java.util.List;

import entity.Book;

/**
 * Created by sq719 on 2018/3/6.
 */

public interface BookView {
    void noData();

    void notifyDatachange(List<Book> books);

    void onFailed(String e);
}
