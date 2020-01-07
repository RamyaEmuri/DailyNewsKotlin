package com.example.dailynewskotlin.view

data class Test(
    val copyright: String,
    val response: Response
) {
    data class Response(
        val meta: Meta,
        val docs: List<Doc>
    ) {
        data class Meta(
            val hits: Int
        )

        data class Doc(
            val `abstract`: String,
            val web_url: String,
            val snippet: String,
            val lead_paragraph: String,
            val print_section: String,
            val print_page: String,
            val source: String,
            val multimedia: List<Multimedia>,
            val headline: Headline,
            val keywords: List<Keyword>,
            val pub_date: String,
            val document_type: String,
            val news_desk: String,
            val section_name: String,
            val subsection_name: String,
            val byline: Byline,
            val type_of_material: String,
            val _id: String,
            val word_count: Int,
            val uri: String
        ) {
            data class Multimedia(
                val rank: Int,
                val subtype: String,
                val type: String,
                val url: String,
                val height: Int,
                val width: Int,
                val subType: String,
                val crop_name: String,
                val caption: Any,
                val credit: Any
            )

            data class Headline(
                val main: String,
                val kicker: Any,
                val content_kicker: Any,
                val print_headline: String,
                val name: Any,
                val seo: Any,
                val sub: Any
            )

            data class Keyword(
                val name: String,
                val value: String,
                val rank: Int,
                val major: String
            )

            data class Byline(
                val original: String,
                val person: List<Person>,
                val organization: Any
            ) {
                data class Person(
                    val firstname: String,
                    val lastname: String,
                    val role: String,
                    val organization: String,
                    val rank: Int,
                    val middlename: Any,
                    val qualifier: Any,
                    val title: Any
                )
            }
        }
    }
}