<#macro page>
    <#import "/spring.ftl" as spring />
    <html lang="en">
        <head>
            <link rel="stylesheet" type="text/css" href="<@spring.url '/quest.css'/>"/>
        </head>
        <body bgcolor="#efefef">
            <div class="flex-container"/>
                <header><p class="monospace">Quest For 92</a></header>
                <article class="article">
                    <#nested>
                </article>

             </div>
        </body>
    </html>
</#macro>