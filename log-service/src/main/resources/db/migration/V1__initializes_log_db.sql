CREATE TABLE audit_log (
    id UUID PRIMARY KEY,
    received_routing_key VARCHAR(255) NOT NULL,
    user_id UUID NOT NULL,
    timestamp TIMESTAMP
);