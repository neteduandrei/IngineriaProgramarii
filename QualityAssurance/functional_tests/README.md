# Functional tests

## What does this do

This module tests the BackEnd server's functionality. Just run ```./run_functional_tests.sh``` to give it a try.

## Development

To add tests, in the forms directory create pass_*.json files. This are the passing tests.

The testing script will send this json to the BackEnd server and test if the form was created.

You can also add failing tests, having the following file format: fail_*.json.

The testing script will send this json to the BackEnd server and test if the request failed.
