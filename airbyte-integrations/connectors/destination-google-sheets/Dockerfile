FROM python:3.9-slim

# Bash is installed for more convenient debugging.
# Include socat binary in the connector image
RUN apt-get update && apt-get install -y bash && apt-get install -y socat && rm -rf /var/lib/apt/lists/*

ENV AIRBYTE_ENTRYPOINT "python /airbyte/integration_code/main.py"

WORKDIR /airbyte/integration_code
COPY setup.py ./
RUN pip install .
COPY destination_google_sheets ./destination_google_sheets
COPY main.py ./

ENTRYPOINT ["python", "/airbyte/integration_code/main.py"]

LABEL io.airbyte.version=0.2.3
LABEL io.airbyte.name=airbyte/destination-google-sheets
