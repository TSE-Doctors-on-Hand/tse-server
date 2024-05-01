# Run from Project Root!

# Stop and remove all containers
docker compose down

# Rebuild Gradle Project
./gradlew build

# Re-build the kotlin image
docker build .

# Re-start containers
docker compose up -d