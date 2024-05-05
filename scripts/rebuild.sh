# Run from Project Root!

# Re-build the kotlin image
docker build .

# Rebuild Docker-compose
docker compose build

# Re-start containers
docker compose up -d

# Inserting data into db
docker compose exec postgres psql -U myuser -d mydatabase -f ./scripts/InsertSymptoms.sql