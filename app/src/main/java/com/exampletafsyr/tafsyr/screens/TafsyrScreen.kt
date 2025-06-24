package com.exampletafsyr.tafsyr.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exampletafsyr.tafsyr.R
import com.exampletafsyr.tafsyr.ui.theme.BackGColor1
import com.exampletafsyr.tafsyr.ui.theme.BackGColor2
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor1
import com.exampletafsyr.tafsyr.ui.theme.CardMainColor2
import com.exampletafsyr.tafsyr.ui.theme.TextColor

@Composable
fun TafsyrScreen() {
    val pagerState = rememberPagerState(pageCount = {
        10
    })
    val scrollState = rememberScrollState()
    val soura: String = "البقرة"

    HorizontalPager(
        state = pagerState, modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient
                    (colors = listOf(BackGColor1, BackGColor2))
            ), reverseLayout = true
    ) { page ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Ibn Katheer",
                        fontSize = 15.sp,
                        color = TextColor,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily(Font(R.font.amiriquran))


                    )
                    Text(
                        text = "ابن كثير",
                        fontSize = 15.sp,
                        color = TextColor,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily(Font(R.font.amiriquran))

                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = soura, fontSize = 14.sp,
                    color = TextColor, modifier = Modifier.size(width = 30.dp, height = 34.dp),
                    fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.amiriquran))

                )
                Spacer(modifier = Modifier.height(10.dp))




                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(height = 32.dp, width = 40.dp)
                        .clip(CircleShape)
                        .background(
                            brush = Brush.linearGradient
                                (colors = listOf(CardMainColor1, CardMainColor2))
                        )
                ) {


                    Text(
                        text = "102",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )

                }


                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "وَٱتَّبَعُواْ مَا تَتۡلُواْ ٱلشَّيَٰطِينُ عَلَىٰ مُلۡكِ سُلَيۡمَٰنَۖ وَمَا كَفَرَ سُلَيۡمَٰنُ وَلَٰكِنَّ ٱلشَّيَٰطِينَ كَفَرُواْ يُعَلِّمُونَ ٱلنَّاسَ ٱلسِّحۡرَ وَمَآ أُنزِلَ عَلَى ٱلۡمَلَكَيۡنِ بِبَابِلَ هَٰرُوتَ وَمَٰرُوتَۚ وَمَا يُعَلِّمَانِ مِنۡ أَحَدٍ حَتَّىٰ يَقُولَآ إِنَّمَا نَحۡنُ فِتۡنَةٞ فَلَا تَكۡفُرۡۖ فَيَتَعَلَّمُونَ مِنۡهُمَا مَا يُفَرِّقُونَ بِهِۦ بَيۡنَ ٱلۡمَرۡءِ وَزَوۡجِهِۦۚ وَمَا هُم بِضَآرِّينَ بِهِۦ مِنۡ أَحَدٍ إِلَّا بِإِذۡنِ ٱللَّهِۚ وَيَتَعَلَّمُونَ مَا يَضُرُّهُمۡ وَلَا يَنفَعُهُمۡۚ وَلَقَدۡ عَلِمُواْ لَمَنِ ٱشۡتَرَىٰهُ مَا لَهُۥ فِي ٱلۡأٓخِرَةِ مِنۡ خَلَٰقٖۚ وَلَبِئۡسَ مَا شَرَوۡاْ بِهِۦٓ أَنفُسَهُمۡۚ لَوۡ كَانُواْ يَعۡلَمُونََ",
                    fontSize = 13.sp,
                    color = TextColor,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.amiriquran)),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                        contentDescription = "next",
                        modifier = Modifier.size(height = 30.dp, width = 25.dp)
                    )
                    if (pagerState.currentPage != 0) {
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                            contentDescription = "back",
                            modifier = Modifier.size(height = 30.dp, width = 25.dp)
                        )
                    }
                }
                Text(
                    text = ": التفسير", fontSize = 16.sp,
                    color = TextColor, modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.amiriquran)),
                    textAlign = TextAlign.Right
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "ولما تركوا دين الله اتبعوا بدلًا عنه ما تَتَقَوَّلُهُ الشياطين كذبًا على مُلك نبي الله سليمان عليه السلام، حيث زعمت أنه ثَبّت ملكه بالسحر، وما كفر سليمان بتعاطي السحر - كما زعمت اليهود - ولكن الشياطين كفروا حيث كانوا يعلِّمون الناس السحر، ويعلمونهم السحر الذي أُنزل على الملَكين: هاروت وماروت، بمدينة بابل بالعراق، امتحانًا وابتلاء للناس، وما كان هذان الملكان يُعَلِّمان أيّ أحد السحر حتى يحذّراه ويبيِّنا له بقولهما: إنما نحن ابتلاء وامتحان للناس فلا تكفر بتعلمك السحر، فمن لم يقبل نصحهما تعلَّم منهما السحر، ومنه نوع يفرق بين الرجل وزوجته، بزرع البغضاء بينهما، وما يضر أولئك السحرة أيَّ أحد إلا بإذن الله ومشيئته، ويتعلمون ما يضرهم ولا ينفعهم، ولقد علم أولئك اليهود أن من استبدل السحر بكتاب الله ما له في الآخرة من حظ ولا نصيب، ولبئس ما باعوا به أنفسهم حيث استبدلوا السحر بوحي الله وشرعه، ولو كانوا يعلمون ما ينفعهم ما أقدموا على هذا العمل المَشِين والضلال المبين",
                    fontSize = 13.sp,
                    color = TextColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.notonaskharabic_variablefont_wght)),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier
                        .size(width = 180.dp, height = 40.dp)
                        .background(
                            brush = Brush.linearGradient
                                (colors = listOf(CardMainColor1, CardMainColor2)),
                            shape = RoundedCornerShape(12.dp)
                        ), contentAlignment = Alignment.Center
                ) {

                    Text(
                        "خروج",
                        fontSize = 19.sp,
                        fontFamily = FontFamily(Font(R.font.notonaskharabic_variablefont_wght)),
                        color = Color.White
                    )


                }

            }
        }
    }

}


@Preview
@Composable
fun TafsyrPreview() {
    TafsyrScreen()
}