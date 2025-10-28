# Creation of a Dockerfile

# Base Image - Existing Image from Docker Hub
FROM ubuntu:latest

# Maintainer Information
LABEL maintainer="awaisahmed.mca24@rvce.edu.in"
LABEL version="1.0"

# Update the package list and install curl
RUN apt-get update && apt-get install -y curl

# Add an existing file
COPY sample.txt /sample.txt

# Communicate the installation process
RUN echo "curl has been successfully installed!"

# Set the entry point to the shell
ENTRYPOINT ["/bin/sh"]
