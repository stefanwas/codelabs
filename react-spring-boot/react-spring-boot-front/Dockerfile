# Use node image ver 8
FROM node:8

# Create app directory to hold the application code inside the image
WORKDIR /usr/src/app

# Install app dependencies
# A wildcard is used to ensure both package.json AND package-lock.json are copied where available (npm@5+)
COPY package*.json ./
RUN npm install


# Bundle app sources into docker image
COPY . .

EXPOSE 8080

CMD [ "npm", "start" ]