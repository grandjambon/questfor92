<!DOCTYPE html>

<#import "lib/utils.ftl" as u>

<@u.page>
    <#function background value>
      <#if value>
        <#return "white" />
      <#else>
        <#return "#474040" />
      </#if>
    </#function>
    <#function font value>
      <#if value>
        <#return "black" />
      <#else>
        <#return "white" />
      </#if>
    </#function>
    <center>
        <table width=75%>
            <tr>
                <td style="text-align:center; font-size:80px" bgcolor="white">92 Club : ${ninetyTwoClubTotal}/92</td>
            </tr>
        </table>

        <br/>
        <br/>

        <#list divisions as division>
            <table style="border: 1px solid black;" width=75%>
                <tr>
                    <td style="border: 1px solid black; border-spacing: 15px; text-align:center; font-size:60px" bgcolor="white">${division.name}</td>
                    <td style="border: 1px solid black; border-spacing: 15px; text-align:center; font-size:60px" bgcolor="white">${division.ninetyTwoClubTotal}/${division.teams?size}</font></td>
                </tr>
            </table>
            <#list division.teams as team>
                <table style="border: 1px solid black;" width = 75%>
                    <tr>
                        <td bgcolor=${background(team.visited92Club)} style="border: 1px solid black"><font color=${font(team.visited92Club)}>${team.name}</font></td>
                    </tr>
                </table>
            </#list>
            <br/>
        </#list>
    </center>
</@u.page>