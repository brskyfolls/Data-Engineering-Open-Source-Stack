# Data Engineering Tools Setup with Docker

This repository provides a Bash script and Docker Compose configuration to easily set up various open-source data engineering tools, including Airbyte, Dagster, and OpenMetadata, for quick deployment and testing. The setup leverages Docker containers to ensure a consistent and reproducible environment.

## Features

- **Airbyte**: A platform for data integration, allowing seamless data ingestion from various sources.
- **Dagster**: An orchestration platform for building and monitoring data pipelines.
- **OpenMetadata**: A metadata management tool that integrates with other data tools to enhance data governance.
- **dbt**
- **Dremio**
- **Elasticsearch and PostgreSQL**: Used for storage and indexing within the metadata management setup.
- **Docker Compose**: Orchestrates the setup and configuration of services.

## Prerequisites

- **Docker** and **Docker Compose** installed on your system.
- Basic understanding of Docker and Docker Compose.

## Getting Started

1. **Clone the repository**:
   ```bash
   git clone https://github.com/brskyfolls/data-engineering-tools-setup.git
   cd data-engineering-tools-setup```

2. **Run the Bash script to set up the environment**:
  ```bash
  ./run-ab-platform.sh
  ```

## Access the Services

- **Airbyte**: [http://localhost:8000](http://localhost:8000)
- **Dagster Webserver**: [http://localhost:3000](http://localhost:3000)
- **OpenMetadata**: [http://localhost:8585](http://localhost:8585)

## Configuration

The default configuration can be customized through the environment variables specified in the `docker-compose.yml` file. The configurations include PostgreSQL credentials, Airbyte settings, and other service parameters.

## Services Overview

### Airbyte

A data ingestion tool that supports numerous data sources. In this setup, Airbyte can be accessed via its web interface for configuring connectors and running data syncs.

### Dagster

Used for orchestrating data pipelines. The setup includes a PostgreSQL backend for Dagster's metadata storage and multiple Docker services to run the web server, daemon, and user code.

### OpenMetadata

An open-source tool for metadata management. It integrates with data platforms like Elasticsearch and PostgreSQL for indexing and storage. The server can be accessed for managing metadata and connecting to other data tools.

### Additional Services

- **PostgreSQL**: Used as a metadata store for Dagster and OpenMetadata.
- **Elasticsearch**: Indexing for OpenMetadata.

## Volumes

Docker volumes are used to persist data for services like PostgreSQL, Elasticsearch, and Dagster.

- `ingestion-volume-dag-airflow`
- `ingestion-volume-dags`
- `ingestion-volume-tmp`
- `es-data`
- `dremio`

## License

All tools included in this setup are open-source.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

## Acknowledgments

- [Airbyte](https://airbyte.io/)
- [Dagster](https://dagster.io/)
- [OpenMetadata](https://open-metadata.org/)
- [Docker](https://www.docker.com/)
