#!/bin/bash


PARENT_DIR=~/Documents/rvce/SEM1

SUB=(OOPS MATH SKILLS COMPNET WAP MISC)

size=${#SUB[@]}

for ((i in "${}")); do
  sub=${PARENT_DIR}/${SUB_NAME}/${SUB[${i}]}
  mkdir -p "$sub"
  for ((j=0;j<6;j++)); do 
    unit=${PARENT_DIR}/${SUB_NAME}/${SUB[${i}]}/UNIT_${j}
    mkdir -p "$unit"
  done
done


