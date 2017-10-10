#!/usr/bin/env bash

SCRIPT_DIR=$(readlink -f $(dirname ${BASH_SOURCE[0]}))
black='\E[30;47m'
red='\E[31;47m'
green='\E[32;47m'
blue='\E[34;47m'

tput bold; echo -e $red $SCRIPT_DIR
tput sgr0 
printf "\n\nPress any key to continue."
read -n 1
