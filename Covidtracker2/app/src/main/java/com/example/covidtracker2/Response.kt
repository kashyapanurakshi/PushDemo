package com.example.covidtracker2

data class Response(
	val stateWise: List<StateWiseItem?>?
)

data class StateWiseItem(
	val rchanges: Int? = null,
	val districtData: List<String?>? = null,
	val dChanges: Int? = null,
	val active: Int? = null,
	val confirmed: Int? = null,
	val recovered: Int? = null,
	val aChanges: Int? = null,
	val cChanges: Int? = null,
	val rChanges: Int? = null,
	val id: String? = null,
	val state: String? = null,
	val deaths: Int? = null,
	val achanges: Int? = null,
	val dchanges: Int? = null,
	val cchanges: Int? = null
)

