package com.gymi.domain;

import java.sql.Timestamp;

public interface IDateTimeProvider {
    Timestamp getUtcNow();
}
