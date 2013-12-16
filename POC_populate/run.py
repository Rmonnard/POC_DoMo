#############################
#  Team DoMo
#  OSF - POC
#  This is a file for populating the POC project
#############################

from HTTPRequest import HTTPRequest
import requests
from math import *
from random import choice, randint
import random, string




class PopulateProject():

	# URL of API
	API_URL = 'http://localhost:8080/POC_Project/%s'


	def __init__(self):
		self.req = HTTPRequest(self.API_URL)


	def populate(self):

		for i in range(1000):
			person = {
			  "firstName" : self.randomword(randint(5,15)),
			  "lastName" : self.randomword(randint(5,15)),
			  "email" : "%s@%s.com" % (self.randomword(randint(5,15)), self.randomword(randint(4,8)))
			}
			self.req.post('PersonsServlet', person)

	def randomword(self, length):
		return ''.join(random.choice(string.lowercase) for i in range(length))


if __name__ == '__main__':
	pp = PopulateProject()
	pp.populate()
