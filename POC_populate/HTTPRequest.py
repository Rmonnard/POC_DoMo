#############################
#  OSF - Gamification
#  Class helpful for sending rest requests
#  Team DoMO
#############################

import urllib2, urllib
import json
from StringIO import StringIO

import requests

class HTTPRequest():

	def __init__(self, api_url):
		self.API_URL = api_url

	HEADERS = {
		'Accept': 'application/json',
		'Content-Type': 'application/json',
		'Cache-Control': 'no-cache'
	}

	def get(self, url):
		return requests.get(self.API_URL % url, headers=self.HEADERS)

	def post(self, url, post):
		return requests.post(self.API_URL % url, data=self.getDataAsString(post), headers=self.HEADERS)

	def put(self, url, post):
		return requests.put(self.API_URL % url, data=self.getDataAsString(post), headers=self.HEADERS)

	def delete(self, url):
		return requests.delete(self.API_URL % url, headers=self.HEADERS)

	def getDataAsString(self, data):
		io = StringIO()
		json.dump(data, io)
		return io.getvalue()



