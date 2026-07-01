package com.example.homework3.data

import kotlinx.serialization.Serializable
import kotlin.collections.listOf

@Serializable
data class GameModel(
    val id: String,
    val name: String,
    val iconUrl: String,
    val releaseDate: Int
)

object GamesRepository {
    val games = listOf(
        GameModel("1","Minecraft","https://i.pinimg.com/736x/52/53/6c/52536c15e7a102b7d6e3376ac99618df.jpg", 2011),
        GameModel("2","CS2","https://ih1.redbubble.net/image.5273118055.5498/st,small,507x507-pad,600x600,f8f8f8.jpg", 2023),
        GameModel("3","Dota 2", "https://avatars.mds.yandex.net/i?id=c985dea013ae0d4c8c5c3d5947cb2fb6388777f6-5288161-images-thumbs&n=13", 2013 ),
        GameModel("4", "Fortnite", "https://i.pinimg.com/originals/19/a7/a9/19a7a92b1c586cd62019b3e2066d8e18.jpg", 2017 ),
        GameModel("5","Valorant", "https://i.pinimg.com/736x/51/d6/de/51d6def892f689d44a7ab1db6b090715.jpg",2020 ),
        GameModel("6","GTA 5", "https://i3.wp.com/logos-world.net/wp-content/uploads/2021/02/GTA-5-Emblem.png?resize=758%2C758&ssl=1", 2013),
        GameModel("7","Cyberpunk 2077", "https://mir-s3-cdn-cf.behance.net/project_modules/1400/81a4e680815973.5cec6bcf6aa1a.jpg", 2020),
        GameModel("8", "The Witcher 3", "https://avatars.mds.yandex.net/i?id=47f1aa54f5a50318f81598ae0cee1d6cd380fdd5-4234271-images-thumbs&n=13", 2015),
        GameModel("9", "Rocket League", "https://img.icons8.com/color/1200/rocket-league.jpg", 2015 ),
        GameModel("10", "League of Legends", "https://avatars.mds.yandex.net/i?id=f63edd386296cf279547c816b6c4213cec5e25a4-4971443-images-thumbs&n=13", 2009 )
    )
}