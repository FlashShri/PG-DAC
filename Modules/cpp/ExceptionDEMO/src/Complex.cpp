/*
 * Comlex.cpp
 *
 *  Created on: 19-Sep-2023
 *      Author: shrik
 */



#include"../include/IllegalArgumentException"
using namespace exception;
#include"../include/Complex"
using namespace nutil;

// definitions of Complex class member functions

Complex::Complex( int real , int imag  ){
			this->setReal( real );
			this->setImag( imag );
		}
		int Complex::getReal( void )const throw( ){
			return this->real;
		}
		void Complex::setReal( const int real ){
			if( real < 0 )
				throw IllegalArgumentException("Invalid real number");
			this->real = real;
		}
		int Complex::getImag( void )const throw( ){
			return this->imag;
		}
		void Complex::setImag( const int imag ){
			if( imag < 0 )
				throw IllegalArgumentException("Invalid imag number");
			this->imag = imag;
		}

		


