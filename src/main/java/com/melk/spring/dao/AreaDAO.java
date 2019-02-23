package com.melk.spring.dao;

import java.util.List;

import com.melk.spring.model.Area;

public interface AreaDAO {

    public List<Area> listArea();

    public List<Area> listAreaByCity(double IdCity);

    public Area getAreaId(String AreaName, double IdCity);

}
