package LibraryConsoleApp.users;

import LibraryConsoleApp.users.ReaderUser;

import java.io.Reader;
import java.util.List;

public class ReadersBase {
    private List<ReaderUser> readers;
    private int maxId = -1;

    public ReadersBase(List<ReaderUser> readers) {
        this.readers = readers;
        readers.forEach(Reader -> {
            if (Reader.getId() >= this.maxId) {
                maxId = Reader.getId() + 1;
            }
        });

    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public List<ReaderUser> getReaders() {
        return readers;
    }

    public void setReaders(List<ReaderUser> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        return readers.toString();
    }

    public ReaderUser searchByLogin(String login){
        return readers.stream().filter(ReaderUser -> login.equals(ReaderUser.getLogin())).findAny().orElse(null);
    }

    public List<ReaderUser> updateReader(ReaderUser readerUser){
        this.readers.set(readerUser.getId(), readerUser);
        return this.readers;
    }

    public ReaderUser searchById(int id){
        return readers.stream().filter(ReaderUser -> id == ReaderUser.getId()).findAny().orElse(null);
    }

    public void add(ReaderUser readerUser){
        this.readers.add(readerUser);
    }
}
