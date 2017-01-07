package com.gstu.dao;

import com.gstu.executor.Executor;
import com.gstu.models.Ticket;
import com.gstu.services.ConnectionFactory;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class TicketDao implements CrudDao<Ticket, Long> {

    private Executor executor = new Executor(ConnectionFactory.getConnection());
    private static Logger log = Logger.getLogger(Ticket.class);

    // QUERIES
    private static final String INSERT_TICKET_QUERY = "INSERT INTO ticket (user_idUser) VALUES (?) ";


    public int insertTicket(long id) {
        return executor.execUpdate(INSERT_TICKET_QUERY, id);
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */

    @Override
    public Ticket findById(Long id) throws SQLException {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public List<Ticket> findAll() {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Ticket update(Ticket entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    @Override
    public Ticket save(Ticket entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public void deleteById(Long aLong) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }
}
