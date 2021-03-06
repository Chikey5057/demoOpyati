package h8.chikey.dao;

import java.util.List;

public interface DAO <Entity,Key>{
    void create (Entity entity);
    void delete (Entity entity);
    void update (Entity entity);
    Entity read (Key key);
    List<Entity> readAll();
}
