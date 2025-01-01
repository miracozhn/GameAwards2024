package com.example.gameawards2024.ui.components

import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun YouTubePlayer(
    videoId: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webChromeClient = WebChromeClient()
                webViewClient = WebViewClient()
                settings.apply {
                    javaScriptEnabled = true
                    loadWithOverviewMode = true
                    useWideViewPort = true
                }
            }
        },
        update = { webView ->
            val embedHtml = """
                <!DOCTYPE html>
                <html>
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <style>
                            body { margin: 0; }
                            .video-container {
                                position: relative;
                                padding-bottom: 56.25%;
                                height: 0;
                                overflow: hidden;
                            }
                            .video-container iframe {
                                position: absolute;
                                top: 0;
                                left: 0;
                                width: 100%;
                                height: 100%;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="video-container">
                            <iframe
                                width="100%"
                                height="100%"
                                src="https://www.youtube.com/embed/$videoId"
                                frameborder="0"
                                allowfullscreen>
                            </iframe>
                        </div>
                    </body>
                </html>
            """.trimIndent()
            webView.loadData(embedHtml, "text/html", "UTF-8")
        }
    )
} 