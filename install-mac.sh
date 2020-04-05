#!/bin/bash

# install Homebrew
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

# install JDK
brew cask install java

# install maven
brew install maven

# install node.js
brew install node

# install yarn
npm install -g yarn
