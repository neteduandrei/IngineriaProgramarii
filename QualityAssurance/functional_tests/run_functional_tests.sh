#!/bin/bash

# Copyright @ Valentin Rosca <rosca.valentin2012@gmail.com>

backend_endpoint="https://b2formeditor.ddns.net/api/v1"

# Return response code from string curl output
get_code() {
	resp=$1

	# get last reponse code - there will be a trailing whitespace
	response_code=$(echo -n "$resp" | grep "HTTP/.*" | tail -1 | grep -oP "[ ].*?$")
	
	# remove trailing whitespaces
	response_code=$(echo -e "${response_code}" | tr -d '[:space:]')
	
	echo -n "$response_code"
}

# Return the first character from a string
get_first_char() {
	echo -n $(echo -n "$1" | head -c 1)
}

# Check test status code, exit if different from 2xx
test_status() {
	response_code=$(get_code "$1")

	# get first number of code
	response_status=$(get_first_char $response_code)
	if [[ $response_status != '2' ]]; then
		printf "Status ${YELLOW}${response_code}${NC}\n${RED}Test failed! $2${NC}\n\n ${RED}Response body is:${NC}\n$1"
		exit 1;
	fi;
}

# Check test status code, exit if equal to 2xx
not_test_status() {
	response_code=$(get_code "$1")

	# get first number of code
	response_status=$(get_first_char $response_code)
	if [[ $response_status = '2' ]]; then
		printf "Status ${YELLOW}${response_code}${NC}\n${RED}Test failed! $2${NC}\n"
		exit 1;
	fi;
}

rm cookies.txt # delete old cookie file
touch cookies.txt # create a new cookie file preserving access right

# Set up colors
RED='\033[0;31m' # Red color for terminal
GREEN='\033[032m' # Green color for terminal
YELLOW='\033[1;33m' # Yellow color for terminal
NC='\033[0m' # No Color


# sign up
printf "> Starting sign up procedure. Sending ${YELLOW}POST${NC} request ... "
response=$(curl -X POST 					` # do a post request` \
	 -H "Content-Type: application/json" 	` # set the header app type - warn the server of json format` \
	 -H "Accept: application/json"			` # set the header app type - tell the server to send back json` \
	 -c cookies.txt 						` # use the local cookie file` \
	 -d @user.json 							` # send user.json file as request body` \
	 -i 									` # include HTTP-header in response` \
	 2>/dev/null 							` # discard curl loading message` \
	 ${backend_endpoint}/authentication/signup)

code=$(get_code "$response")

printf "Status "
first=$(get_first_char $code)

if [[ $first = '2' ]]; then
	printf "${GREEN}${code}${NC}\n\n${GREEN}  Sign up succesfull!${NC}\n\n"
else
	printf "${YELLOW}${code}${NC}\n\n${RED}  Sign up failed.${NC} This is normal if the user already exists. Login should succed if this is the case.\n\n"
fi


# it doesn't matter if sign up failed or not
# if it failed that means the user already exists
# otherwise it wall be created
# login should work either way

# login
printf "> Starting login procedure. Sending ${YELLOW}POST${NC} request ... "
response=$(curl -X POST 					` # do a post request` \
	 -H "Content-Type: application/json" 	` # set the header app type - warn the server of json format` \
	 -H "Accept: application/json"			` # set the header app type - tell the server to send back json` \
	 -c cookies.txt 						` # use the local cookie file` \
	 -d @user.json 							` # send user.json file as request body` \
	 -i 									` # include HTTP-header in response` \
	 2>/dev/null 							` # discard curl loading message` \
	 ${backend_endpoint}/authentication/login)

code=$(get_code "$response")
test_status "$response" "Could not login!"
printf "Status ${GREEN}${code}${NC}\n"

printf "\n${GREEN}  Login succesfull!${NC}\n\n"

let test_nr=1

printf "> ${GREEN}Starting passing tests${NC}\n\n"
for file in $(find forms -type f | grep -e "/pass_.*.json$"); do
	printf ">> Test ${GREEN}${test_nr}${NC}, file ${GREEN}${file}${NC}\n"

	# create a new form
	printf ">>> Sending ${YELLOW}POST${NC} request to create form ... "
	response=$(curl \
		-X POST 								` # do a post request` \
		-H "Content-Type: application/json" 	` # set the header app type - warn the server of json format` \
	 	-H "Accept: application/json"			` # set the header app type - tell the server to send back json` \
	 	-c cookies.txt 							` # use the local cookie file for storage` \
	 	-b cookies.txt							` # send the cookie file to server for the session` \
	    -d @${file} 							` # send form json as request body for form creation` \
	    -i 										` # include HTTP-header in response` \
	 	2>/dev/null 							` # discard curl loading message` \
	 	${backend_endpoint}/forms)

	code=$(get_code "$response")
	test_status "$response" "Could not create form!"
	printf "Status ${GREEN}${code}${NC}\n"

	formId=$(echo -n "$response" | grep -o "{.*}" | jq -r '.id')

	# test if form was created
	printf ">>> ${GREEN}Test${NC} if form with id ${YELLOW}${formId}${NC} was created. Sending ${YELLOW}GET${NC} request ... "
	response=$(curl \
		-X GET	 								` # do a get request` \
		-H "Content-Type: application/json" 	` # set the header app type - warn the server of json format` \
	 	-H "Accept: application/json"			` # set the header app type - tell the server to send back json` \
	 	-c cookies.txt 							` # use the local cookie file for storage` \
	 	-b cookies.txt							` # send the cookie file to server for the session` \
	 	-I 										` # fetch the HTTP-header only` \
	 	2>/dev/null 							` # discard curl loading message` \
	 	${backend_endpoint}/forms/${formId})
	
	code=$(get_code "$response")
	test_status "$response" "Could not retrieve form!"
	printf "Status ${GREEN}${code}${NC}\n"


	printf ">> ${GREEN}Test ${NC}${YELLOW}$test_nr${NC}${GREEN} passed!${NC}\n"

	let test_nr=${test_nr}+1

	printf "\n"
done;

printf "\n> ${GREEN}Starting failing tests${NC}\n\n"
let test_nr=1
for file in $(find forms -type f | grep -e "/fail_.*.json$"); do
	printf ">> Test ${GREEN}${test_nr}${NC}, file ${GREEN}${file}${NC}\n"

	# create a new form
	printf ">>> Sending ${YELLOW}POST${NC} request to create form ... "
	response=$(curl \
		-X POST 								` # do a post request` \
		-H "Content-Type: application/json" 	` # set the header app type - warn the server of json format` \
	 	-H "Accept: application/json"			` # set the header app type - tell the server to send back json` \
	 	-c cookies.txt 							` # use the local cookie file for storage` \
	 	-b cookies.txt							` # send the cookie file to server for the session` \
	    -d @${file} 							` # send form json as request body for form creation` \
	    -i 										` # include HTTP-header in response` \
	 	2>/dev/null 							` # discard curl loading message` \
	 	${backend_endpoint}/forms)


	code=$(get_code "$response")
	formId=$(echo -n "$response" | grep -o "{.*}" | jq -r '.id')
	not_test_status "$response" "Form with id ${YELLOW}${formId}${NC} was created when it shoudn't!"
	printf "Status ${RED}${code}${NC}\n"


	printf ">> ${GREEN}Test ${NC}${YELLOW}$test_nr${NC}${GREEN} passed!${NC}\n"

	let test_nr=${test_nr}+1

	printf "\n"
done;

printf "${GREEN}All${NC} tests passed!\n"

exit 0;
