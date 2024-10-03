# Base image for Node.js build
FROM node:20 AS build

# Set working directory inside the container
WORKDIR /app

# Copy the app code to the working directory
COPY . /app

# Install dependencies and build the AngularJS project
RUN npm install
RUN npm run build --prod

# Stage 2: Serve the AngularJS app using Nginx
FROM nginx:alpine

# Copy the built app from the previous stage to the Nginx public directory
COPY --from=build /app/dist /usr/share/nginx/html

# Expose port 8080 to serve the app
EXPOSE 8080

# Start Nginx server
CMD ["nginx", "-g", "daemon off;"]
