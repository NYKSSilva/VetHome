ALTER TABLE consulta
    ADD COLUMN slot_ativo TINYINT AS (IF(status_consulta = 'pendente', 1, NULL)) STORED,
    ADD UNIQUE KEY uk_consulta_slot_ativo (data_consulta, horario_consulta, slot_ativo);
