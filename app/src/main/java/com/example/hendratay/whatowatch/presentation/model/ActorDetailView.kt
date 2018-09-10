package com.example.hendratay.whatowatch.presentation.model

data class ActorDetailView(val birthday: String?,
                           val knownForDepartment: String,
                           val deathDay: String?,
                           val id: Int,
                           val name: String,
                           val alsoKnownAs: List<String>,
                           val gender: Int,
                           val biography: String,
                           val popularity: Number,
                           val placeOfBirth: String?,
                           val profilePath: String?,
                           val adult: Boolean,
                           val imdbId: String,
                           val homepage: String?)
