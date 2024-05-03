package co.edu.uan.android.simpsonsbottomnavigation312.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val logo = "https://miro.medium.com/v2/resize:fit:1100/format:webp/1*oAnY6k_KzDAj97H1_xzdLQ.png"
    val history = MutableLiveData<String>().apply {
        value = "The Simpsons is an American animated sitcom created by Matt Groening for the Fox Broadcasting Company.[1][2][3] Developed by Groening, James L. Brooks, and Sam Simon, the series is a satirical depiction of American life, epitomized by the Simpson family, which consists of Homer, Marge, Bart, Lisa, and Maggie. Set in the fictional town of Springfield, it caricatures society, Western culture, television, and the human condition.\n" +
                "\n" +
                "The family was conceived by Groening shortly before a solicitation for a series of animated shorts with producer Brooks. He created a dysfunctional family and named the characters after his own family members, substituting Bart for his own name; he thought Simpson was a funny name in that it sounded similar to \"simpleton\".[4] The shorts became a part of The Tracey Ullman Show on April 19, 1987. After three seasons, the sketch was developed into a half-hour prime time show and became Fox's first series to land in the Top 30 ratings in a season (1989–1990)."
    }

    fun changeText() {
        history.value = "The Simpsons received widespread acclaim throughout its early seasons in the 1990s, which are generally considered its \"golden age\". Since then, it has been criticized for a perceived decline in quality. Time named it the 20th century's best television series,[9] and Erik Adams of The A.V. Club named it \"television's crowning achievement regardless of format\".[10] On January 14, 2000, the Simpson family was awarded a star on the Hollywood Walk of Fame. It has won dozens of awards since it debuted as a series, including 37 Primetime Emmy Awards, 34 Annie Awards, and 2 Peabody Awards. Homer's exclamatory catchphrase of \"D'oh!\" has been adopted into the English language, while The Simpsons has influenced many other later adult-oriented animated sitcom television series."

    }
}

