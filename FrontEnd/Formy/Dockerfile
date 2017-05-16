FROM node:6.10.2
COPY ./*.json /formy/
RUN cd /formy && \
	npm install -g @angular/cli && \
	npm install
COPY ./ /formy
RUN cd /formy/src/app/shared && sed -e "s^https://89.203.249.188:8443^http://localhost:8090^g" -i globals.ts
CMD cd /formy && ng serve --host 0.0.0.0 
