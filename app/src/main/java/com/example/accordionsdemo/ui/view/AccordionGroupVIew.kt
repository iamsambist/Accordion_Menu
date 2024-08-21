import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.accordionsdemo.model.AccordionGroup
import com.example.accordionsdemo.model.ModelAccordion
import com.example.accordionsdemo.ui.theme.Gray200
import com.example.accordionsdemo.ui.theme.Gray600
import com.example.accordionsdemo.ui.theme.MedGray3

@Composable
fun AccordionGroupView(modifier: Modifier = Modifier, group: List<ModelAccordion>){
    Column(modifier = modifier.padding(WindowInsets.statusBars.asPaddingValues())) {
        group.forEach {
            Accordion(model = it)
        }
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Accordion(modifier: Modifier = Modifier,model : ModelAccordion){
    var expanded by remember { mutableStateOf(false) }

    Column(modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        AccordionHeader(
            title = model.header,
            hasChild = AccordionGroup.hasChild(model),
            isExpanded = expanded) {
            expanded = !expanded
        }
        AnimatedVisibility(visible = expanded) {
            Surface(
                color = White,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                LazyColumn {
                    items(model.rows) { row ->
                        AccordionRow(row)
                        Divider(color = Gray200, thickness = 1.dp)
                    }
                }
            }
        }
    }
}
@Composable
private fun AccordionHeader(
    title: String = "Header",
    isExpanded: Boolean = false,
    hasChild : Boolean = false,
    onTapped: () -> Unit = {}
) {
    val degrees = if (isExpanded) 180f else 0f
    Surface(
        color = White,
    ) {
        Row(
            modifier = Modifier
                .clickable { onTapped() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(title, Modifier.weight(1f), color = Gray600)
            if(hasChild){

            Surface(color = White.copy(alpha = 0.6f)) {
                Icon(
                    Icons.Outlined.ArrowDropDown,
                    contentDescription = "arrow-down",
                    modifier = Modifier.rotate(degrees),
                    tint = Black
                )
            }
            }
        }
    }
}
@Composable
private fun AccordionRow(
    model: ModelAccordion.Row = ModelAccordion.Row("AAPL", "$328.89")
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clickable {  }
    ) {
        Text(model.security, Modifier.weight(1f), color = MedGray3)
            Text(
                text = model.price,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                color = White
            )

    }
}