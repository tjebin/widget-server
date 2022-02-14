package com.example.tjebin.widget.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tjebin.widget.models.Widget;
import com.example.tjebin.widget.repositories.WidgetRepository;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

    public Widget createWidgetFormaterial(String materialId, Widget widget) {
        widget.setmaterialId(materialId);
        return repository.save(widget);
    }

    public List<Widget> findAllWidgets() {
          return repository.findAllWidgets();
    }

    public List<Widget> findWidgetsFormaterial(String materialId) {
        return repository.findWidgetsFormaterial(materialId);
    }

    public Integer deleteWidget(Long id) {
        repository.deleteById(id);
        return 1;
    }

    public Widget findWidgetById(Long id) {
        return repository.findWidgetById(id);
    }

    public Integer updateWidget(Long id, Widget widget) {
        Widget newWidget = widget;
        Widget originalWidget = findWidgetById(id);
        originalWidget.setText(newWidget.getText());
        originalWidget.setType(newWidget.getType());
        originalWidget.setHeight(newWidget.getHeight());
        originalWidget.setSize(newWidget.getSize());
        originalWidget.setOrdered(newWidget.getOrdered());
        originalWidget.setUrl(newWidget.getUrl());
        originalWidget.setWidth(newWidget.getWidth());
        originalWidget.setText2(newWidget.getText2());
        repository.save(originalWidget);
        return 1;
    }
}
