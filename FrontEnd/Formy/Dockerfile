FROM node:6.10.2

# Precache node and angular dependencies
COPY ./*.json /formy/
RUN cd /formy && \
	npm install -g @angular/cli && \
	npm install

# Prepare environment for formy
COPY ./ /formy

# Make sure that the local BackEnd is used
RUN cd /formy/src/app/shared && sed -e "s^https://.*:8443^http://localhost:8090^g" -i globals.ts

# Finally run the development server
CMD cd /formy && ng serve --host 0.0.0.0 
