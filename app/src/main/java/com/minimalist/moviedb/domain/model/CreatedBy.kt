package com.minimalist.moviedb.domain.model

data class CreatedBy(val id: Int,
                     val creditId: String,
                     val name: String,
                     val gender: Int,
                     val profilePath: String?)