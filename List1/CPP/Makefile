all:
	clang++ -std=c++17 -ggdb3 -Weverything -Wno-c++98-compat -Wno-c++98-compat-pedantic -I./include src/converter_lib.cpp src/*.cpp prog/main.cpp -o ./bin/main

test:
	clang++ -std=c++17 -ggdb3 -Weverything -Wno-c++98-compat -Wno-c++98-compat-pedantic -I./include src/converter_lib.cpp src/*.cpp prog/test.cpp -o ./bin/test