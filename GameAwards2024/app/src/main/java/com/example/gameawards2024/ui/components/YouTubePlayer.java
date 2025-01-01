package com.example.gameawards2024.ui.components;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public class YouTubePlayer extends FrameLayout {
    private WebView webView;
    private String videoId;

    public YouTubePlayer(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        webView = new WebView(context);
        webView.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));
        
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        
        addView(webView);
    }

    public void loadVideo(String videoId) {
        this.videoId = videoId;
        String embedHtml = "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset=\"UTF-8\">" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
            "<style>" +
            "body { margin: 0; }" +
            ".video-container {" +
            "position: relative;" +
            "padding-bottom: 56.25%;" +
            "height: 0;" +
            "overflow: hidden;" +
            "}" +
            ".video-container iframe {" +
            "position: absolute;" +
            "top: 0;" +
            "left: 0;" +
            "width: 100%;" +
            "height: 100%;" +
            "}" +
            "</style>" +
            "</head>" +
            "<body>" +
            "<div class=\"video-container\">" +
            "<iframe" +
            " width=\"100%\"" +
            " height=\"100%\"" +
            " src=\"https://www.youtube.com/embed/" + videoId + "\"" +
            " frameborder=\"0\"" +
            " allowfullscreen>" +
            "</iframe>" +
            "</div>" +
            "</body>" +
            "</html>";

        webView.loadData(embedHtml, "text/html", "UTF-8");
    }
} 