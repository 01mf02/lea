#!/bin/bash
find -name "*.dot" -exec dot -Tpdf \{\} -o \{\}.pdf \;
