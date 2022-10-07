package com.poit.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.poit.dao.ApplianceDAO;
import com.poit.entity.Appliance;
import com.poit.entity.criteria.Criteria;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {
    private static final String xmlFilePath = "D:\\User Files\\University\\Web-Tech\\Lab2\\lab2\\src\\main\\resources\\data.xml";
    @Override
    public List<Appliance> find(Criteria criteria) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlString = new String(Files.readAllBytes(Paths.get(xmlFilePath)));
            List<Appliance> appliances = xmlMapper.readValue(xmlString, new TypeReference<List<Appliance>>() {
            });
            if (criteria.getGroupSearchName().equals(""))
                return appliances;
            List<Appliance> concreateAppliances = new ArrayList<>();
            for(var item: appliances){
                if (item.getClass().getSimpleName().equals(criteria.getGroupSearchName()))
                    concreateAppliances.add(item);
            }
            List<Appliance> filtredAppliance = new ArrayList<>();
            var map = criteria.getCriteriaMap();
            for(Map.Entry<String, Object> entry: map.entrySet()){
                String fieldToSearch = entry.getKey();
                Object valueToSeacrh = entry.getValue();
                for(var item: concreateAppliances){
                    var field = item.getClass().getDeclaredField(fieldToSearch);
                    field.setAccessible(true);
                    if (field.get(item).equals(valueToSeacrh))
                        filtredAppliance.add(item);
                }
            }
            return filtredAppliance;
        } catch (IOException | IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
