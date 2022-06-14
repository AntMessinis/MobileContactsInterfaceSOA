package MobileContactsInterfaceSOA.model;

public abstract class AbstractEntity implements IdentifiableEntity{
    protected long id;

    public AbstractEntity() {}

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
