common
========================
This library template is designed to allow us to create a new library quickly and easily.

In order to use this library as a template you can follow these steps:
  - Clone this project in your workspace.
  - Create a new repository on github.
  - cd into common
  - run the following command: python runner.py .
    - You will be prompted for your github repo. Enter in the https url related to the new github repo you just created.
    - You will be prompted for your project name, use the same name you used to create your git repo.
  - Now your newly created git repo will have the template code. A folder will also be created in your workspace with the name of your project.
  - You can now make changes from the newly created folder in your workspace.


Setting up Jenkins:
  - You will want to setup a jenkins job by going to the following URL: https://api-phx.cicd.prod.int.godaddy.com/api/v1/jobs/
  - CLick "Create". The environment should be set to build, githubUrl = https://jenkins.intranet.gdg/github-webhook/, jobType = integration.
  - Your git push commands should now trigger a new build on jenkins.
  

This library comes with:
  - Java 1.8
  - Lombok 1.16.2
  - Automatic push scripts for continuous deployment via jenkins.
  - Unit testing and code coverage setups.
  - Guava 18.0
  - maven release plugin support.
