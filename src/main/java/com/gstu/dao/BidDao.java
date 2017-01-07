package com.gstu.dao;

import com.gstu.executor.Executor;
import com.gstu.models.Bid;
import com.gstu.services.ConnectionFactory;
import org.apache.log4j.Logger;

import java.util.List;

public class BidDao implements CrudDao<Bid,Long> {

    private static Logger log = Logger.getLogger(BidDao.class);
    private Executor executor = new Executor(ConnectionFactory.getConnection());

    private static final String INSERT_BID = "INSERT INTO bid VALUES(?)";

    public int insertBid(Bid bid){
        return executor.execUpdate(INSERT_BID,bid);
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Bid findById(Long id) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public List<Bid> findAll() {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Bid update(Bid entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public Bid save(Bid entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    /**
     * The method is not supported
     *
     * @throws UnsupportedOperationException, when calling
     */
    @Override
    public void deleteById(Long aLong)  {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }
}
