package com.example.tjebin.widget.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.tjebin.widget.models.Widget;

public interface WidgetRepository
    extends CrudRepository<Widget, Long> {

    @Query(value="SELECT * FROM widgets WHERE id=:wid", nativeQuery = true)
    public Widget findWidgetById(@Param("wid") Long widgetId);

    @Query(value="SELECT * FROM widgets", nativeQuery = true)
    public List<Widget> findAllWidgets();

    @Query(value="SELECT * FROM widgets WHERE material_id=:tid", nativeQuery = true)
    public List<Widget> findWidgetsFormaterial(@Param("tid") String materialId);
}
