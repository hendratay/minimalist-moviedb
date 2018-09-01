package com.example.hendratay.whatowatch.data.entity

import com.google.gson.annotations.SerializedName

data class TvDetailEntity(@SerializedName("backdrop_path") val backdropPath: String?,
                          @SerializedName("created_by") val createdBy: List<CreatedByEntity>,
                          @SerializedName("episode_run_time") val episodeRunTime: List<Int>,
                          @SerializedName("first_air_date") val firstAirDate: String,
                          @SerializedName("genres") val genres: List<GenresEntity>,
                          @SerializedName("homepage") val homepage: String,
                          @SerializedName("id") val id: Int,
                          @SerializedName("in_production") val inProduction: Boolean,
                          @SerializedName("languages") val languages: List<String>,
                          @SerializedName("last_air_date") val lastAirDate: String,
                          @SerializedName("last_episode_to_air") val lastEpisodeToAir: LastEpisodeToAirEntity,
                          @SerializedName("name") val name: String,
                          @SerializedName("networks") val networks: List<NetworksEntity>,
                          @SerializedName("number_of_episodes") val numberOfEpisodes: Int,
                          @SerializedName("number_of_seasons") val numberOfSeasons: Int,
                          @SerializedName("origin_country") val originCountry: List<String>,
                          @SerializedName("origin_language") val originLanguage: String?,
                          @SerializedName("origin_name") val originName: String?,
                          @SerializedName("overview") val overview: String,
                          @SerializedName("popularity") val popularity: Number,
                          @SerializedName("poster_path") val posterPath: String?,
                          @SerializedName("production_companies") val productionCompaniesEntity: List<ProductionCompaniesEntity>,
                          @SerializedName("seasons") val seasons: List<SeasonsEntity>,
                          @SerializedName("status") val status: String,
                          @SerializedName("type") val type: String,
                          @SerializedName("vote_average") val voteAverage: Number,
                          @SerializedName("vote_count") val voteCount: Int)