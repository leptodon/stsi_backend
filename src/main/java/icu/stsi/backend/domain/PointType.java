package icu.stsi.backend.domain;

import java.util.HashMap;
import java.util.Map;

public enum PointType {
    STATIC(0L),
    MOVE(1L),
    CREW(2L);

    private Long id;

    PointType(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private static Map<Long, PointType> typeMap = new HashMap<>();

    static {
        for (PointType type : PointType.values()) {
            typeMap.put(type.getId(), type);
        }
    }

    public static PointType getById(Long id) {
        return typeMap.get(id);
    }
}
