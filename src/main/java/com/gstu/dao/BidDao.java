package com.gstu.dao;

import com.gstu.models.Bid;
import org.apache.log4j.Logger;

import java.util.List;

public class BidDao implements CrudDao<Bid,Long> {

    private static Logger log = Logger.getLogger(BidDao.class);

    @Override
    public Bid findById(Long id) {
        return null;
    }

    @Override
    public List<Bid> findAll() {
        return null;
    }

    @Override
    public Bid update(Bid entity) {
        return null;
    }

    @Override
    public Bid save(Bid entity) {
        log.error(new UnsupportedOperationException());
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong)  {

    }
}
