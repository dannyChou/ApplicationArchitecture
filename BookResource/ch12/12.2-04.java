class AbstractMapper...

    abstract public void update(DomainObject arg);

class AlbumMapper...

    public void update(DomainObject arg) {
        PreparedStatement statement = null;
        try {
            statement = DB.prepare(
                "UPDATE albums SET title = ?, artistID = ? WHERE id = ?");
            statement.setLong(3, arg.getID().longValue());
            Album album = (Album) arg;
            statement.setString(1, album.getTitle());
            statement.setLong(2, album.getArtist().getID().longValue());
            statement.execute();
        } catch (SQLException e) {
            throw new ApplicationException(e);
        } finally {
            cleanUp(statement);
        }
    }